str = "12345678";
numbers = "";
notnumbers = "";
i = 0;
while (i < length(str)) {
	if (toNum(charAt(str, i)) == 0) {
		notnumbers = concat(notnumbers, charAt(str, i));
	} else {
		numbers = concat(numbers, charAt(str, i));	
	}

	i = i + 1;
}