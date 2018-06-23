package nl.hu.ipass.gitaarshop.webservices;

import java.io.IOException;
import com.sendgrid.*;

public class mailService {

	public boolean sendEmail(String email, String onderwerp, String message) throws IOException {
		Email from = new Email(email);
		String subject = onderwerp;
		Email to = new Email("santino.denbrave@student.hu.nl");
		Content content = new Content("text/plain", message);
		Mail mail = new Mail(from, subject, to, content);

		// Creates new object with api-key.
		SendGrid sg = new SendGrid("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");
		Request req = new Request();
		try {
			req.setMethod(Method.POST);
			req.setEndpoint("mail/send");
			req.setBody(mail.build());
			Response response = sg.api(req);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
			return true;
		} catch (IOException ex) {
			throw ex;
		}
	}
}
