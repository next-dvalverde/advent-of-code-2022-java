
help: ## show make targets
	@awk 'BEGIN {FS = ":.*?## "} /[a-zA-Z_-]+:.*?## / {sub("\\\\n",sprintf("\n%22c"," "), $$2);printf " \033[36m%-20s\033[0m  %s\n", $$1, $$2}' $(MAKEFILE_LIST)

start: install-deps ## add gitHooks and install dependencies
	@if [ ! -f $(current-dir).env ]; then touch .env && echo "Created .env PLEASE, FILL WITH AOC_SESSION=<SESSION>"; fi
	@git config core.hooksPath .githooks

install-deps: ## install deps
	@./mvnw install

clean: ## maven clean
	@./mvnw clean

new_day: ## create new day with day parameter
	@cp templates/DayXX.java src/main/java/aoc2022/Day${day}.java
	@sed -i 's/XX/${day}/g' src/main/java/aoc2022/Day${day}.java
	@cp templates/DayXXTest.java src/test/java/aoc2022/Day${day}Test.java
	@sed -i 's/XX/${day}/g' src/test/java/aoc2022/Day${day}Test.java
	@touch src/main/resources/aoc2022/Day${day}.txt
	@touch src/main/resources/aoc2022/Day${day}_test.txt

.PHONY: help start install-deps clean new_day