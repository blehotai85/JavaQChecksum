
public class JavaQChecksum {
    
	public static String getCrc(String input, int len) {

	byte[] bytes = input.getBytes();
	
	int crc_tbl[] = {
            0x0000, 0x1081, 0x2102, 0x3183,
            0x4204, 0x5285, 0x6306, 0x7387,
            0x8408, 0x9489, 0xa50a, 0xb58b,
            0xc60c, 0xd68d, 0xe70e, 0xf78f
        };
        
        int crc = 0xffff;
        char c;
        int i = 0;
        while (len-- > 0) {
            c = (char) bytes[i++];
            crc = ((crc >> 4) & 0x0fff) ^ crc_tbl[((crc ^ c) & 15)];
            c >>= 4;
            crc = ((crc >> 4) & 0x0fff) ^ crc_tbl[((crc ^ c) & 15)];
        }
        return Integer.toHexString(~crc & 0xffff);

    }
}
