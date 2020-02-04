# CLAM static analyzer
CLAM static analyzer is a static analyzer based on abstract interpretation for MuDyn, an imperative toy dynamic language. Full details of MuDyn language and CLAM can be found in [Completeness of Abstract Domains for String Analysis of JavaScript Programs](https://link.springer.com/chapter/10.1007%2F978-3-030-32505-3_15) presented in the 16th International Colloquium on Theoretical Aspects of Computing (ICTAC 2019).

The MuDyn syntax is reported in the following.

![image](syn.png)

## How to run the tool
```
git clone https://github.com/VincenzoArceri/clam
```
You can either build the Eclipse Project, run the JAR file `clam.jar` as
```
java -jar clam.jar filename.js 
```
or execute CLAM by using Docker

```
docker pull vincenzoarceri/clam
docker run -v /absolute/path/to/local/file.js:/file.js vincenzoarceri/clam file.js
```

Some options are available:
* `-tajs`: set the TAJS string abstract domain (default)
* `-safe`: set the SAFE string abstract domain
* `-tajs-shell`: set the TAJS complete shell string abstract domain
* `-safe-shell`: set the SAFE complete shell string abstract domain
* `-tajs-comp `: performs the analysis with both the TAJS string domain and its complete shell (showing precision entropy information)
* `-safe-comp `: performs the analysis with both the SAFE string domain and its complete shell (showing precision entropy information)
* `-invariants `: prints the invariants for each program point. By default, it prints only the abstract state holding at the exit program point
* `-help`: print the menu.

## Example
Consider the following MuDyn program.

```
str = "24kobe8";
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
```

The output of `java -jar -coalesced clam.jar file.js --tajs-comp` prints, for each prorgam point a table similar to the following (that is the table for the exit program point)

```
| Variable  | TAJS original domain| TAJS shell domain   | Precision increment|
|============================================================================|
| str       | "24kobe8"           | "24kobe8"           | -                  |
| notnumbers| String              | UnsignedOrNotNumeric| 1                  |
| numbers   | String              | UnsignedOrNotNumeric| 1                  |
| i         | UnsignedInt         | UnsignedInt         | -                  |

```
## Contributors
- Vincenzo Arceri vincenzo.arceri@univr.it
- Martina Olliaro martina.olliaro@unive.it
- Tino Cortesi cortesi@unive.it
- Isabella Mastroeni isabella.mastroeni@univr.it
