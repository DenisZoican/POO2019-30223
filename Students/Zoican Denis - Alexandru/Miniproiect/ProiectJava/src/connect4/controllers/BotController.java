package connect4.controllers;

import connect4.models.NodeMatrix;
import connect4.models.Point;

public class BotController {
	static Boolean noMoreMoves(NodeMatrix[][] a) {
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 7; j++) {
				if (a[i][j].getPlayer() == -1)
					return false;
			}
		return true;
	}

	static int count_board(int[] a,int player)
	{
	    int s = 0;

	    for(int i=0; i<4; i++)
	        if(a[i]==player)
	        {
	            s++;
	        }

	    return s;
	}
	
	static int evaluate_board(NodeMatrix[][] a, int player, int opponent) {
		int score = 0;
		int c[] = new int[4];
	    ///horizontal
	    for(int i=0; i<6; i++)
	    {
	        for(int j=0; j<4; j++)
	        {
	            for(int k=0; k<4; k++)
	            {
	                c[k]=a[i][j+k].getPlayer();
	            }

	            int count_p = count_board(c,player);
	            int count_o = count_board(c,opponent);

	            if(count_p==2)
	            {
	                score+=10;
	            }

	            if (count_o==2)
	            {
	                score-=10;
	            }

	            if(count_p==3)
	            {
	                score+=100;
	            }

	            if(count_o==3)
	            {
	                score-=100;
	            }

	            if(count_p==4)
	            {
	                return 10000000;
	            }

	            if(count_o==4)
	            {
	                return -10000000;
	            }
	        }
	    }


	    ///vertical
	    for(int j=0; j<7; j++)
	    {
	        for(int i=0; i<3; i++)
	        {
	            for(int k=0; k<4; k++)
	            {
	                c[k]=a[i+k][j].getPlayer();
	            }
	            int count_p = count_board(c,player);
	            int count_o = count_board(c,opponent);

	            if(count_p==2)
	            {
	                score+=10;
	            }
	            if(count_o==2)
	            {
	                score-=10;
	            }

	            if(count_p==3)
	            {
	                score+=100;
	            }
	            if(count_o==3)
	            {
	                score-=100;
	            }

	            if(count_p==4)
	            {
	                return 10000000;
	            }
	            if(count_o==4)
	            {
	                return -10000000;
	            }
	        }
	    }

	    ///diagonal UL-DR
	    for(int i=0; i<3; i++)
	        for(int j=0; j<4; j++)
	        {
	            for(int k=0; k<4; k++)
	            {
	                c[k]=a[i+k][j+k].getPlayer();
	            }
	            int count_p = count_board(c,player);
	            int count_o = count_board(c,opponent);

	            if(count_p==2)
	            {
	                score+=10;
	            }
	            if(count_o==2)
	            {
	                score-=10;
	            }

	            if(count_p==3)
	            {
	                score+=100;
	            }
	            if(count_o==3)
	            {
	                score-=100;
	            }

	            if(count_p==4)
	            {
	                return 10000000;
	            }
	            if(count_o==4)
	            {
	                return -10000000;
	            }
	        }

	    ///diagonal DL-UR
	    for(int i=0; i<3; i++)
	        for(int j=0; j<4; j++)
	        {
	            for(int k=0; k<4; k++)
	            {
	                c[k]=a[i+3-k][j+k].getPlayer();
	            }
	            int count_p = count_board(c,player);
	            int count_o = count_board(c,opponent);

	            if(count_p==2)
	            {
	                score+=10;
	            }
	            if(count_o==2)
	            {
	                score-=10;
	            }

	            if(count_p==3)
	            {
	                score+=100;
	            }
	            if(count_o==3)
	            {
	                score-=100;
	            }

	            if(count_p==4)
	            {
	                return 10000000;
	            }
	            if(count_o==4)
	            {
	                return -10000000;
	            }
	        }
	    return score;
	}

	static int MinMax(NodeMatrix[][] a, int level, int depth, int player, int opponent) {
		int score = evaluate_board(a, player, opponent);

		if (score == 10000000 || score == -10000000 || depth == 0) {
			return score;
		}

		if (noMoreMoves(a))
			return 0;


		/// Choose maxi
		if (level != 0) {
			int maxi = -100000000;
			for (int j = 0; j < 7; j++) {
				int i = 0;
				while (i <= 5 && a[i][j].getPlayer() == -1) {
					i++;
				}
				i--;
				if (i >= 0 && a[i][j].getPlayer() == -1) {
					a[i][j].setPlayer(player);
					int scoreMinMax = MinMax(a, (level + 1) % 2, depth - 1, player, opponent);
					if (scoreMinMax > maxi) {
						maxi = scoreMinMax;
					}
					a[i][j].setPlayer(-1);
				}
			}
			return maxi;
		} else {
			int maxi = 100000000;

			for (int j = 0; j < 7; j++) {
				int i = 0;
				while (i <= 5 && a[i][j].getPlayer() == -1) {
					i++;
				}
				i--;

				if (i >= 0 && a[i][j].getPlayer() == -1) {
					a[i][j].setPlayer(opponent);
					int scoreMinMax = MinMax(a, (level + 1) % 2, depth - 1, player, opponent);
					if (scoreMinMax < maxi) {
						maxi = scoreMinMax;
					}
					a[i][j].setPlayer(-1);
				}
			}
			return maxi;
		}
	}

	static Point chooseBestMove(NodeMatrix[][] a, int player, int opponent) {

		int mini = -1000000000;
		Point pos = new Point(0, 0);

		for (int j = 0; j < 7; j++) {
			int i = 0;
			while (i <= 5 && a[i][j].getPlayer() == -1) {
				i++;
			}
			i--;

			if (i >= 0 && a[i][j].getPlayer() == -1) {
				a[i][j].setPlayer(player);
				int score = MinMax(a, 0, 3, player, opponent);
				if (score > mini) {
					mini = score;
					pos.setX(i);
					pos.setY(j);
				}
				a[i][j].setPlayer(-1);
			}
		}
		return pos;
	}
}
