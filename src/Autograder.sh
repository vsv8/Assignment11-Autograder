#!/bin/bash
echo "Welcome to Autograder"
echo "Gathering Tests"

java -cp "C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.1\lib\junit-4.12.jar;C:\Users\Arnarleo\Desktop\Master\Profun\MoneyStack\libs\mockito-core-3.8.0.jar;C:\Users\Arnarleo\Desktop\Master\Profun\MoneyStack\libs\byte-buddy-1.10.20.jar;C:\Users\Arnarleo\Desktop\Master\Profun\MoneyStack\libs\byte-buddy-agent-1.10.20.jar;C:\Users\Arnarleo\Desktop\Master\Profun\MoneyStack\libs\objenesis-3.1.jar;C:\Users\Arnarleo\Desktop\Master\Profun\MoneyStack\libs\hamcrest-all-1.3.jar;C:\Users\Arnarleo\Desktop\Master\Profun\MoneyStack\bin" org.junit.runner.JUnitCore AllTests

echo "Starting Pitest"

java -cp "C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.1\lib\junit-4.12.jar;C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.1\plugins\pit-idea-plugin\lib\pitest-command-line-1.6.3.jar;C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.1\plugins\pit-idea-plugin\lib\pitest-1.6.3.jar;C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.1\plugins\pit-idea-plugin\lib\pitest-entry-1.6.3.jar;C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.1\plugins\pit-idea-plugin\lib\pitest-junit5-plugin-0.12.jar;C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.1\plugins\pit-idea-plugin\lib\pit-idea-plugin.jar;C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.1\plugins\pit-idea-plugin\lib\searchableOptions.jar;C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.1\plugins\pit-idea-plugin\lib\xmlpull-1.1.3.1.jar;C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.1\plugins\pit-idea-plugin\lib\xpp3_min-1.1.4c.jar;C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.1\plugins\pit-idea-plugin\lib\xstream-1.4.8.jar;C:\Users\Arnarleo\Desktop\Master\Profun\MoneyStack\libs\mockito-core-3.8.0.jar;C:\Users\Arnarleo\Desktop\Master\Profun\MoneyStack\libs\byte-buddy-1.10.20.jar;C:\Users\Arnarleo\Desktop\Master\Profun\MoneyStack\libs\byte-buddy-agent-1.10.20.jar;C:\Users\Arnarleo\Desktop\Master\Profun\MoneyStack\libs\objenesis-3.1.jar;C:\Users\Arnarleo\Desktop\Master\Profun\MoneyStack\libs\hamcrest-all-1.3.jar;C:\Users\Arnarleo\Desktop\Master\Profun\MoneyStack\bin" org.pitest.mutationtest.commandline.MutationCoverageReport --reportDir "C:\Users\Arnarleo\Desktop\Master\Profun\MoneyStack\reports" --targetClasses MoneyStackTest,MoneyMock,MoneyTest --sourceDirs "C:\Users\Arnarleo\Desktop\Master\Profun\MoneyStack\bin"  --verbose true --timestampedReports false

echo "Starting Jacoco"

java -jar "C:\Users\Arnarleo\Desktop\Master\Profun\lib\jacococli.jar" report "C:\Users\Arnarleo\Desktop\Master\Profun\MoneyStack\src\jacoco.exec" --classfiles "C:\Users\Arnarleo\Desktop\Master\Profun\MoneyStack\bin" --html "C:\Users\Arnarleo\Desktop\Master\Profun\coverage\org.jacoco.report" --name myReport --sourcefiles "C:\Users\Arnarleo\Desktop\Master\Profun\MoneyStack\bin"

grep -o "..\%" "C:\Users\Arnarleo\Desktop\Master\Profun\MoneyStack\reports\index.html" > bang.txt
grep -o "..\%" "C:\Users\Arnarleo\Desktop\Master\Profun\coverage\org.jacoco.report\index.html" >> bang.txt

sort bang.txt | uniq -d > bang.txt

grep "[0-9][0-9]" bang.txt | awk '{sum += $1/4/10} {json = "[{\"grade\": "sum"}]"} END {print json}' > ForGradescope.json

echo "Gradescope rdy"









