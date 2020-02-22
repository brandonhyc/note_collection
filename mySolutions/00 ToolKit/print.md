# Print Map
Arrays.toString(map.entrySet().toArray());

# init Map
HashMap<String, String> h = new HashMap<String, String>() {{
    put("a","b");
}};

# Print Matrix
int[][] array = new int[rows][columns];
System.out.println(Arrays.deepToString(array));


https://stackoverflow.com/questions/7384791/splitting-strings-through-regular-expressions-by-punctuation-and-whitespace-etc
# remove punctuation
1.
String[] Res = Text.split("[\\p{Punct}\\s]+");
2.
String line = "Hello! this is a line. It can't be hard to split into \"words\", can it?";
String[] words = line.split("\\W+");
3.
String[] Res = Text.split("\\P{L}+");
