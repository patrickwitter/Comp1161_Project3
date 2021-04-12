import javax.mail.Message;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PromoterEmail {

    /**
     *
     * @param messContent
     * @param subject This the subject of the Email
     * @param messContent This is the content of the message of the Email
     * @throws Exception
     */
    public static void sendMail(String messContent,String subject) throws Exception {
        String recipient = "jondoeparties@gmail.com";

       // System.out.println("Preparing to send email"); //An output message that notifies the user that the email is about to be sent
        Properties properties = new Properties();


        /**If authentication through username and/or password is required
         * the 'auth' value is set to true
         * using the gmail server requires login with both a username and passowrd
         * so our authentication value is set to true
         **/
        properties.put("mail.smtp.auth", "true"); 

        /**This is a method of encryption that makes the connection from the sending computer
         * ie. the one you are running this code on
         * to the recieving email server host secure
         * We prefer a safe connection, so we set this value to true
         **/
        properties.put("mail.smtp.starttls.enable", "true");

        /**We will be using gmail as our sending and recieving email address
         * As such, we use their predefined host url, which is smtp.gmail.com
         **/
        properties.put("mail.smtp.host", "smtp.gmail.com");

        /**We will be using gmail as our sending and recieving email address
         * As such, we use their predefined port, which is 587
         * This information is available for public disclosure upon research
         **/
        properties.put("mail.smtp.port", "587");


        /**These are variables initialized with the security details of the email address
         * that the message will be sent from
         * Remeber that authentication is required because this program will be acting as our
         * mailing client in place of the actual gmail website
         * So we provide both the email address and the password
         **/
        String myAccountEmail = "jondoeparties@gmail.com";
        String password = "COMP1161Project";


        // This creates a new session for login to the email to take place
        Session session = Session.getInstance(properties, new Authenticator() { //new Authenticator ensures our provided email address and password correspond
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){ 
                return new PasswordAuthentication(myAccountEmail, password); 
                /** Inputing our string variables above in the form of
                 * myAccountEmail which holds our email
                 * and password which hold our password
                 * fills the email address and password into the necessary fields on the side of the host server
                 * which, in this case, is gmail 
                 */
            }
        });

        /** The following method is for preparing the mesage that we hope to send
         * "Message" is already part of the javax.mail API, so it is imported
         **/
        Message message = prepareMessage(session, myAccountEmail, recipient,messContent,subject);


        /** The transport class which is native to the API sends the email through the provided host
         * For this to work, a generic exception was thrown here and in the sendMail class
         */
        Transport.send(message);
       // System.out.println("Message sent successfully"); // An output message informing the user that the code ran and the the message was successfully sent
    }

    /** To send the email, we need to provide the following parameters to our constructor:
     * The session, which is an instance of logging in with the email and password
     * which was authenticated above
     * 
     * The account we wish to send our new email from is used from the session
     * (whichever email we login with is the default email that will be our sender)
     * 
     * The recieving email is also provided as "recipient"
     * In our case, the sender is also the recipient
    */
    private static Message prepareMessage(Session session, String myAccountEmail, String recipient,String messContent,String subject){
        try {
            Message message = new MimeMessage(session);

            //The email address the message will be sent from is in our "FROM" address
            message.setFrom(new InternetAddress(myAccountEmail)); 

            //setRecipient is apart of the javamail API
            // it is the email address that will be receiving the message
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

            //This is the subject field of the email
            message.setSubject(subject);

            //This is the body of the email
            message.setText(messContent);
            
            //This return message adds the subject and body of the message 
            //to the corresponding fields on the side our our mailing host
            return message;
        } catch (Exception ex) {
            //If the message is not sent, we will be informed of a SEVERE failure by the logging level class
            Logger.getLogger(PromoterEmail.class.getName()).log(Level.SEVERE, null, ex); 
        }
        return null;
    }
}
