package com.example.demo.test;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupByMax {
	
	public static void main(String args[]) {
		List<SampleType> values = buildSampleValues();
		List<Optional<SampleType>> groupByValues = 
				values.stream().collect(Collectors.groupingBy(SampleType::getTypeId))
				.values().stream().map(v -> v.stream().max(Comparator.comparing(SampleType::getIDate)))
				.collect(Collectors.toList());
		
		if(!groupByValues.isEmpty()) {
			groupByValues.stream()
			.forEach(v -> System.out.println(" ID " + v.get().getTypeId() + " Date :: " + v.get().getIDate()) );
		}
	}

	private static List<SampleType> buildSampleValues() {
		SampleType type1 = new SampleType("AR", LocalDate.of(2022, 12, 3));
		SampleType type2 = new SampleType("AR", LocalDate.of(2022, 11, 3));
		SampleType type3 = new SampleType("AR", LocalDate.of(2023, 10, 3));
		SampleType type4 = new SampleType("KT", LocalDate.of(2022, 06, 3));
		SampleType type5 = new SampleType("KT", LocalDate.of(2022, 05, 3));
		SampleType type6 = new SampleType("AS", LocalDate.of(2022, 03, 3));
		SampleType type7 = new SampleType("AS", LocalDate.of(2022, 02, 3));
		
		return List.of(type1, type2,type3, type4, type5, type6, type7);
	}

}
