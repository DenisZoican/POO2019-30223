import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainClass {

	static Optional<Integer> isPalindrom(Integer n) {
		String ns = n + "";
		for (int i = 0; i < ns.length() / 2; i++) {
			if (ns.charAt(i) != ns.charAt(ns.length() - i - 1)) {
				return null;
			}
		}
		return Optional.of(n);
	}

	public static void main(String[] args) {
		/// 1
		System.out.println("\n\nExercitiul 1\n\n");
		List<String> list = Arrays.asList("Cainele", "Se", "Uita", "La", "Focul", "De", "Artificii");

		StringBuilder str = new StringBuilder(list.size());
		ListIterator<String> et = list.listIterator();

		while (et.hasNext()) {
			str.append(et.next().charAt(0));
		}

		System.out.println(str);

		/// 2
		System.out.println("\n\nExercitiul 2\n\n");
		List<String> filteredList = list.stream().filter((s) -> s.length() % 2 == 0).collect(Collectors.toList());
		System.out.println(filteredList);

		/// 3
		System.out.println("\n\nExercitiul 3\n\n");
		List<String> mapList = list.stream().map((s) -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(mapList);

		/// 4
		System.out.println("\n\nExercitiul 4\n\n");
		StringBuilder str2 = new StringBuilder();
		Map<String, String> m = new HashMap<String, String>();
		m.put("Zoican1", "1");
		m.put("Zoican2", "2");
		m.put("Zoican3", "3");
		m.put("Zoican4", "4");
		m.put("Zoican5", "5");
		m.put("Zoican6", "6");

		m.forEach((k, v) -> {
			str2.append(k + v);
		});

		System.out.println(str2);

		/// 5
		System.out.println("\n\nExercitiul 5\n\n");
		List<String> list2;

		list2 = list.stream().map((s) -> s.toLowerCase()).collect(Collectors.toList());

		list2.forEach(System.out::println);

		/// 6
		System.out.println("\n\nExercitiul 6\n\n");
		list2 = list.stream().map((s) -> s.length() % 2 == 0 ? s.substring(0, s.length() - 1) : s)
				.collect(Collectors.toList());

		list2.forEach(System.out::println);

		/// 7
		System.out.println("\n\nExercitiul 7\n\n");
		StringBuilder str3 = new StringBuilder();

		int k = 0;
		ListIterator<String> it = list.listIterator();

		while (it.hasNext() && k <= 3) {
			if (k == 1 || k == 2 || k == 3) {
				str3.append(it.next());
				if (k != 3) {
					str3.append('-');
				}
			} else {
				it.next();
			}
			k++;
		}

		System.out.println(str3);

		/// 8

		System.out.println("\n\nExercitiul 8\n\n");
		List<Integer> ints = IntStream.iterate(1, i -> i * 2).mapToObj(Integer::valueOf).limit(10)
				.collect(Collectors.toList());

		System.out.println(ints);

		/// 9
		System.out.println("\n\nExercitiul 9\n\n");
		List<Integer> intList = Arrays.asList(1, 2, 3, 41, 14, 44, 121, 321);

		intList.forEach((s) -> {
			if (isPalindrom(s) != null) {
				System.out.println(s);
			}
		});

		/// 10
		System.out.println("\n\nExercitiul 10\n\n");
		List<Employee> emList = new ArrayList<Employee>();
		emList.add(new Employee("Zoican1", 12, 12.0));
		emList.add(new Employee("Zoican2", 32, 23.023));
		emList.add(new Employee("Zoican3", 3, 3.10));
		emList.add(new Employee("Zoican4", 12, 400.0));
		emList.add(new Employee("Zoican5", 55, 54.0));

		Double aver = emList.stream().mapToDouble((s) -> s.getSalary()).average().getAsDouble();
		System.out.println(aver);

		/// 11
		System.out.println("\n\nExercitiul 11\n\n");
		List<Student> stList = new ArrayList<Student>();

		List<String> courses1 = Arrays.asList("Curs1", "Curs2", "Curs3", "Curs4", "Curs5");
		List<String> courses2 = Arrays.asList("Curs1", "Curs2", "Curs3");
		List<String> courses3 = Arrays.asList("Curs1", "Curs2", "Curs3", "Curs4", "Curs5", "Curs6");

		stList.add(new Student("Zoican1", 8.1, courses1));
		stList.add(new Student("Zoican2", 5.12, courses2));
		stList.add(new Student("Zoican3", 3.14, courses3));
		stList.add(new Student("Zoican4", 9.1, courses2));
		stList.add(new Student("Zoican5", 8.9, courses1));

		Map<String, Integer> ms = new HashMap<String, Integer>();

		stList.forEach((s) -> ms.put(s.getName(), s.getCourses().size()));

		ms.forEach((key, val) -> {
			System.out.println(key + " " + val);
		});

		/// 12
		System.out.println("\n\nExercitiul 12\n\n");
		List<Car> carList = new ArrayList<Car>();

		carList.add(new Car("Car1", 2000, "Color1", 2020.233));
		carList.add(new Car("Car2", 2001, "Color2", 2030.23));
		carList.add(new Car("Car3", 2002, "Color3", 2040.263));
		carList.add(new Car("Car4", 2003, "Color4", 2050.25));
		carList.add(new Car("Car5", 2004, "Color5", 2060.21));
		carList.add(new Car("Car6", 2005, "Color6", 2070.22));

		carList = carList.stream().sorted((p1, p2) -> p2.getPrice().compareTo(p1.getPrice()))
				.collect(Collectors.toList());

		carList.forEach((s) -> System.out.println(s.getBrand()));

		/// 13
		System.out.println("\n\nExercitiul 13\n\n");
		
		List<Integer> fibo = Stream.iterate(new Integer[] {0,1} , i -> new Integer[] {i[1],i[0]+i[1]}).limit(10)
				.map((s)->s[0]).collect(Collectors.toList());

		System.out.println(fibo);
	}

}
