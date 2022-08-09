.PHONY: commit

D = `date +%m-%d-%Y`
commit:
	echo "$D"
	git add .
	git commit -m "${D}"
