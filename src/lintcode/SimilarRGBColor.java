package lintcode;

public class SimilarRGBColor {
	/**
     * @param color: the given color
     * @return: a 7 character color that is most similar to the given color
     */
    public String similarRGB(String color) {
        // Write your code here
    	int[] hexes = new int[16];
    	int[] colorHexes = new int[3];
    	String[] shrts = new String[16];
    	String[] threeColors = new String[3];
    	
    	for (int i = 0; i < 10; i++) {
    		String tmp = String.valueOf(i);
    		shrts[i] = tmp + tmp;
    		hexes[i] = Integer.parseInt(shrts[i], 16);    		
    	}
    	for (int i = 0; i < 6; i++) {
    		String tmp = String.valueOf((char) (97 + i));
    		shrts[i + 10] = tmp + tmp;
    		hexes[i + 10] = Integer.parseInt(shrts[i + 10], 16);
    	}
    	for (int i = 0; i < 3; i++) {
    		colorHexes[i] = Integer.parseInt(color.substring(2 * i + 1, 2 * i + 3), 16);
    	}
    	
    	for (int i = 0; i < 3; i++) {
    		int minDiff = Integer.MAX_VALUE;
    		for (int j = 0; j < 16; j++) {
    			int diff = Math.abs(colorHexes[i] - hexes[j]);
    			if (minDiff > diff) {
    				minDiff = diff;
    				threeColors[i] = shrts[j];
    			}
    		}
    	}
    	return "#" + threeColors[0] + threeColors[1] + threeColors[2];
    }
}
