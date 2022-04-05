find . -name '*.html' | while read LINE; do cat $LINE ; done | grep -v '\$' | ./message.pl | sort -u
find . -name '*.java' | while read LINE; do cat $LINE ; done | grep -v '\$' | ./message.pl | sort -u

