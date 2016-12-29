package controllers;

import play.mvc.Http;

public class SessionController {

	public static void createSessionForUser(String userEmailId) {
		if (userEmailId == null || userEmailId.isEmpty()) {
		}
		Http.Context.current().session().put("email", userEmailId);
	}

	public static boolean clearSession() {
		Http.Context.current().session().clear();
		return true;
	}

	public static String fetchSessionDataForUser() {
		String emailId;
		emailId = Http.Context.current().session().get("email");
		return emailId;
	}

	public static boolean isSessionNotExist() {
		String email = Http.Context.current().session().get("email");
		if (email == null || email.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
