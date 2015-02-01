package com.example.xmldemo.parser;

import java.io.InputStream;
import java.util.List;

import com.example.xmldemo.model.Book;

public interface BookParser {
	/**
	 * ���������� �õ�Book���󼯺�
	 * 
	 * @param is
	 * @throws Exception
	 */
	public List<Book> parse(InputStream is) throws Exception;

	/**
	 * ���л�Book���󼯺� �õ�XML��ʽ���ַ���
	 * 
	 * @param books
	 * @return
	 * @throws Exception
	 */
	public String serialize(List<Book> books) throws Exception;
}
