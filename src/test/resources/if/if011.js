str = "a";

i = 0;
while (i < 100) {
	i = i + 1;
}

if (i < 2) {
	str = concat(str, "b");
} else {
	str = concat(str , "c");
}

z = toNum(str);
