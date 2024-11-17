package app.yarmak.newsportal.controller.concrete;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Command {
	void execute (HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException;
}
