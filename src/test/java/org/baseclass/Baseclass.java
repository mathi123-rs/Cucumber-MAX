package org.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Baseclass {

	public static WebDriver driver;
	


		public static void launchChrome() {
			
			
			
//			 WebDriverManager.edgedriver().setup();
//			    
//			    EdgeOptions edgeOptions = new EdgeOptions();
//			    edgeOptions.addArguments("--headless=new");
//			    edgeOptions.addArguments("--disable-gpu");
//			   
//		        edgeOptions.addArguments("--no-sandbox");
//		        edgeOptions.addArguments("--disable-dev-shm-usage"); 
//		        edgeOptions.addArguments("--disable-cache");
//		        edgeOptions.addArguments("--disable-software-rasterizer");
//		        edgeOptions.addArguments("--enable-javascript");
//		        edgeOptions.addArguments("--window-size=1920,1080");
//		        edgeOptions.addArguments("--verbose");
//		        edgeOptions.addArguments("--use-gl=disabled");
//		        edgeOptions.addArguments("--enable-features=NetworkServiceInProcess");
//		        edgeOptions.addArguments("--dns-prefetch-disable");
//		        edgeOptions.addArguments("--log-level=3");
//		        edgeOptions.setCapability("goog:loggingPrefs", ImmutableMap.of(
//		        	    "browser", "ALL",
//		        	    "performance", "ALL",
//		        	    "driver", "ALL"
//		        	));
//		     
//		        
//			    // ✅ CORRECT: Assign to the static driver
//			    driver = new EdgeDriver(edgeOptions); 
			
			  ChromeOptions options = new ChromeOptions();
	        	String chromeBinaryPath = "/usr/bin/google-chrome";
		        options.setBinary(chromeBinaryPath);
		        options.addArguments("--headless=new"); 
		        options.addArguments("--disable-gpu");
		        options.addArguments("--no-sandbox");
		        options.addArguments("--disable-dev-shm-usage"); 
		        options.addArguments("--disable-cache");
		        options.addArguments("--window-size=1920,1080");	       
		        options.addArguments("--enable-logging");
		        options.addArguments("--log-level=3"); 
		        options.addArguments("--remote-allow-origins=*"); 
		        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	            options.setBrowserVersion("126");
	            options.addArguments("--incognito");
	            driver = new ChromeDriver(options);

};


	public void takeScreenshot(String testName) {
		
		 File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        try {
	            File destFile = new File("./target/surefire-reports/screenshots/" + testName + ".png");
	            destFile.getParentFile().mkdirs();
	            FileUtils.copyFile(srcFile, destFile);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}

	public static void getdriver() {
	    ChromeOptions c = new ChromeOptions();
//	    c.addArguments("--incognito"); // Launch in incognito mode

	    // Optional: add window size or other settings if needed
	     c.addArguments("--window-size=1920,1080");
	    // c.setBrowserVersion("126");

	    driver = new ChromeDriver(c);
	}
	public static void size() throws AWTException {

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_MINUS);
		r.keyRelease(KeyEvent.VK_MINUS);
		r.keyPress(KeyEvent.VK_MINUS);
		r.keyRelease(KeyEvent.VK_MINUS);
		r.keyRelease(KeyEvent.VK_CONTROL);
//		r.keyRelease(KeyEvent.VK_MINUS);
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--window-size=800,600");
		// driver.manage().window().setSize(new Dimension(400, 300));
	}

	public static void winMax() {
		driver.manage().window().maximize();
	}

	public static WebDriver loadUrl(String url) {
		driver.get(url);

		return driver;
	}

	public static WebElement dataPass(WebElement element, String data) {
		element.sendKeys(data);
		return element;
	}
	

	public void  elementClick(WebElement element) {
		element.click();
		
	
	}

	public void selectOptbyIndex(WebElement element, int index) {

		Select select = new Select(element);
		select.selectByIndex(index);
	}

//	public static String excelData(int rowNo, int cellNo) {
//        String filePath = "src/test/resources/Testdata/Lmx-smoke prod.xlsx"; // Excel file path
//        String value = "";  // To store extracted cell data
//
//        try (FileInputStream fis = new FileInputStream(new File(filePath));
//             Workbook book = new XSSFWorkbook(fis)) {
//
//            Sheet sheet = book.getSheet("Sheet1");
//            Row row = sheet.getRow(rowNo);
//            Cell cell = row.getCell(cellNo);
//
//            if (cell != null) {
//                switch (cell.getCellType()) {
//                    case STRING:
//                        value = cell.getStringCellValue();
//                        break;
//                    case NUMERIC:
//                        if (DateUtil.isCellDateFormatted(cell)) {
//                        	Date date = cell.getDateCellValue();
//                        	LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//                        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd,MMMM,yyyy");
//                        	value = localDate.format(formatter);
//                        } else {
//                            value = String.valueOf((long) cell.getNumericCellValue());
//                        }
//                        break;
//                    case BOOLEAN:
//                        value = String.valueOf(cell.getBooleanCellValue());
//                        break;
//                    case FORMULA:
//                        value = cell.getCellFormula();
//                        break;
//                    case BLANK:
//                        value = "";
//                        break;
//                    default:
//                        value = "Unknown Data Type";
//                }
//            }
//
//            // ✅ Replace "+" with a random UUID substring if present
//            if (value.contains("+")) {
//                UUID uuid = UUID.randomUUID();
//                value = value.replace("+", uuid.toString().substring(0, 5));
//                System.out.println("Data modified: " + value);
//            }
//
//        } catch (IOException e) {
//            System.err.println("Error reading Excel file: " + e.getMessage());
//        }
//
//        return value;
//    }

//    public static void main(String[] args) {
//        // Example Usage
//        String data = excelData(1, 3);  // Read from row 1, cell 3
//        System.out.println("Final Extracted Data: " + data);
//    }
//	
	
	
	
	

	
	

	public static void imtWait(int w) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

//	public static void sendEmailNotification(String domainName) {
//
//		final String senderEmail = Configproperties.properties.getProperty("sendermail");
//		final String senderPassword = Configproperties.properties.getProperty("senderpassword");
//		String[] recipients = Configproperties.properties.getProperty(domainName + "mailrecipients").split(",");
//		String subject = Configproperties.properties.getProperty(domainName + "mailsubject");
//		String diplayMessage = Configproperties.properties.getProperty(domainName + "displaymessage");
//		String authenticate = "mail.smtp.auth";
//		String smtpenable = "mail.smtp.starttls.enable";
//		String host = "mail.smtp.host";
//		String port = "mail.smtp.port";
//		String sslprotocols = "mail.smtp.ssl.protocols";
//		Date currentDate = new Date();
//		SimpleDateFormat twelveHourFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
//		twelveHourFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
//		String formattedDateTwelveHour = twelveHourFormat.format(currentDate);
//		String errorMsg = "\nDate and Time (IST - 12-hour format): " + formattedDateTwelveHour;
//
//		String errorMsg1 = Configproperties.properties.getProperty("displaymessage");
//
//		// Mail server properties
//		Properties props = new Properties();
//		props.put(authenticate, Configproperties.properties.getProperty("mail.smtp.auth"));
//		System.out.println(authenticate);
//		props.put(smtpenable, Configproperties.properties.getProperty("mail.smtp.starttls.enable"));
//		System.out.println(smtpenable);
//		props.put(host, Configproperties.properties.getProperty("mail.smtp.host"));
//		System.out.println(host);
//		props.put(port, Configproperties.properties.getProperty("mail.smtp.port"));
//		System.out.println(port);
//		props.put(sslprotocols, Configproperties.properties.getProperty("mail.smtp.ssl.protocols"));
//
//		Session session = Session.getInstance(props);
//
//		try {
//			// Compose the message
//			Message message = new MimeMessage(session);
//			message.setFrom(new InternetAddress(senderEmail));
//
//			// Add multiple recipients
//			InternetAddress[] recipientAddresses = new InternetAddress[recipients.length];
//			for (int i = 0; i < recipients.length; i++) {
//				recipientAddresses[i] = new InternetAddress(recipients[i]);
//			}
//			message.setRecipients(Message.RecipientType.TO, recipientAddresses);
//
//			message.setSubject(subject); // Set the subject
//
//			message.setText(diplayMessage + errorMsg); // Set the email content
//
//			// Connect to the SMTP server and send the message
//			Transport transport = session.getTransport("smtp");
//			transport.connect(Configproperties.properties.getProperty("mail.smtp.host"), 587, senderEmail,
//					senderPassword);
//			transport.sendMessage(message, message.getAllRecipients());
//			transport.close();
//
//			System.out.println("Email notification sent successfully.");
//		} catch (MessagingException e) {
//			System.out.println("Failed to send email notification: " + e.getMessage());
//		}
//
//	}
//	
	public void sendKeys(WebElement element, String keys) {
		element.sendKeys(keys);

	}

	public WebElement findbyid(String attribute) {

		WebElement element = driver.findElement(By.id(attribute));

		return element;

	}

	public void dragandaDropElement(WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}

	public void loginclick(WebElement element) {

		element.click();
	}

	public void clearvalue(WebElement element) {
		element.clear();
	}

	public static void implicitWait(long duration) {

		driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}

	public static void maximise() {
		driver.manage().window().maximize();
	}

	public WebElement findbyxpath(String attribute) {
		WebElement element = driver.findElement(By.xpath(attribute));

		return element;

	}

	public void isselected(WebElement element) {

		boolean selected = element.isSelected();
		if (selected == true) {
			System.out.println("selected");

		} else {
			System.out.println("not selected");

		}
	}

	public void handleAlertByAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void isdisplayed(WebElement element) {

		boolean displayed = element.isDisplayed();
		if (displayed == true) {
			System.out.println("displayed");

		} else {
			System.out.println("not displayed");

		}
	}
	
	
	
	
}
