package programa.formatos;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 * 
 * @author WesleySilva
 *
 */
public class FormatFactory {
	public static final String DEFAULT_STRING = "*##d*$*E*$*f*$*A*$*u*$*L*$*t##*";
	public static final String CPF_FORMAT = "###.###.###-##";
	public static final String DATE_FORMAT = "dd/MM/yyyy";
	public static final int CPF_TAMANHO = 14;
	public static final int DEFAULT_INT = 1;
	
	/**
	 * Create a formatter factory, all arguments of the DateFormatter are dates formated as
	 * "dd/MM/yyyy".
	 * 
	 * @return
	 * 			The date formatter factory.
	 */
	public static DefaultFormatterFactory createDateFactory() {
		return 	new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat(FormatFactory.DATE_FORMAT)),
				  							new DateFormatter(new SimpleDateFormat(FormatFactory.DATE_FORMAT)),
				  							FormatFactory.createMaskFormatter("##/##/####"));
	}
	
	/**
	 * Create a formatter factory for a cpf field.
	 * 
	 * @return
	 * 			The cpf formatter factory.
	 */
	public static DefaultFormatterFactory createCpfFactory() {
		return new DefaultFormatterFactory(null, 
										   null,
										   FormatFactory.createMaskFormatter(FormatFactory.CPF_FORMAT));
	}
	
	/**
	 * Create a mask based on a String object.
	 * 
	 * @param formatString 
	 *			The String object.
	 * @return
	 *			A MaskFormatter object.
	 * @throws ParseException
	 * 			If the passed String characters doesn't meet those ones that the constructor expects.
	 */
	public static MaskFormatter createMaskFormatter(String formatString) {
		try {
			return new MaskFormatter(formatString);
		} catch(ParseException e) {
			return null;
		}
	}
	
	/**
	 * 
	 * @param vString
	 * @return
	 */
	public static boolean validateString(String vString) {
		if (!(validateNonNullString(vString))) return false;
		
		for (int i = 0; i < vString.length(); i++) {
			if (vString.charAt(i) != ' ') return true;
		}
		
		return false;
	}
	
	public static boolean validateStringReverse(String vString) {
		if (!(validateNonNullString(vString))) return false;
		
		for (int i = 0; i < vString.length(); i++) {
			if (vString.charAt(i) == ' ') return false;
		}
		
		return true;
	}
	
	public static boolean validateDigitOnlyString(String vString) {
		if (!(validateNonNullString(vString))) return false;
		
		for (int i = 0; i < vString.length(); i++) {
			if (!(Character.isDigit(vString.charAt(i)))) return false;
		}
		
		return true;
	}
	
	public static boolean validateNonNullString(String vString) {
		if (vString == null || vString.equals("")) return false;
		return true;
	}
	
	/**
	 * Converts a date to GregorianCalendar.
	 * 
	 * @param date
	 * 			The date which the user wants to convert.
	 * @return
	 * 			The converted GregorianCalendar.
	 */
	public static GregorianCalendar dateToGregorianCalendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
	}
	
	/**
	 * Converts a String to a date object.
	 * 
	 * @param stringDate
	 * 			The String which the user wants to convert.
	 * @return
	 * 			The converted Date.
	 * @throws ParseException
	 * 			If the String given doesn't meet dd/MM/yyyy.
	 */
	public static Date stringToDate(String stringDate) throws ParseException {
		return new SimpleDateFormat(FormatFactory.DATE_FORMAT).parse(stringDate);
	}
	
	/**
	 * Converts a date to a String.
	 * 
	 * @param date
	 * 			The Date which the user wants to convert.
	 * @return
	 * 			The converted String.
	 */
	public static String dateToString(Date date) {
		return new SimpleDateFormat(FormatFactory.DATE_FORMAT).format("date");
	}
	
	/**
	 * Converts a String to a GregorianCalendar.
	 * 
	 * @param stringDate
	 * 			The String which the user wants to convert.
	 * @return
	 * 			The converted GregorianCalendar.
	 * @throws ParseException
	 * 			If the String given doesn't meet dd/MM/yyyy. 
	 */
	public static GregorianCalendar stringToGregorianCalendar(String stringDate) throws ParseException {
		return FormatFactory.dateToGregorianCalendar(FormatFactory.stringToDate(stringDate));
	}
	
	/**
	 * Converts GregorianCalendar to a String.
	 * 
	 * @param calendarDate
	 * 			The GregorianCalendar which the user wants to convert.
	 * @return
	 * 			The converted String.
	 */
	public static String gregorianCalendarToString(GregorianCalendar calendarDate) {
		return DateFormat.getDateInstance(DateFormat.DEFAULT).format(calendarDate.getTime());
	}
	
	public static long timeToDays(long time) {
		return TimeUnit.DAYS.convert(time, TimeUnit.MILLISECONDS);
	}
	
	public static int calendarToDays(GregorianCalendar begin, GregorianCalendar end) throws ParseException {
		Date tempBeginDate = begin.getTime();
		long beginTime = tempBeginDate.getTime();
		Date tempEndDate = end.getTime();
		long endTime = tempEndDate.getTime();
		return (int) FormatFactory.timeToDays(endTime - beginTime);
	}
}
