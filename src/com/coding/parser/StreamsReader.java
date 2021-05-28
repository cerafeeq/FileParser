package com.coding.parser;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import com.coding.parser.model.FileItem;

import java.util.Iterator;


public class StreamsReader {
	private static PriorityQueue<FileItem> pq = new PriorityQueue<FileItem>();

	public static void main(String[] args) {
		if (args[0] != null) {
			Path inputFile = Paths.get(args[0]);
			StreamsReader proc = new StreamsReader();
			
			try {
				proc.process(inputFile, "ce");
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		while (!pq.isEmpty()) {
			FileItem item = pq.poll();
			System.out.println(item);
		}
	}
	
	public void process(Path file, String keyword) throws IOException {
		try (Stream<String> lineStream = Files.lines(file)) {
			lineStream.forEach(line -> {
				int index = line.indexOf(keyword);
				if (index != -1) {
					System.out.println("index " + index);
					pq.add(new FileItem(line, index));
				}
			});
		}
	}
}
