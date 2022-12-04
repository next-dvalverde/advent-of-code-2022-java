
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

remove_day: ## remove day classes with day parameter
	@rm src/main/java/aoc2022/Day${day}.java
	@rm src/test/java/aoc2022/Day${day}Test.java
	@rm src/main/resources/aoc2022/Day${day}.txt
	@rm src/main/resources/aoc2022/Day${day}_test.txt

all_tests: ## execute all tests
	@./mvnw test

test: ## execute test by parameter
	@./mvnw test -Dtest=Day${day}Test

format: ## format code
	@./mvnw prettier:write

check-format: ## check format code
	@./mvnw prettier:check

all-tests-pipeline: ## execute all tests
	@mvn test

check-format-pipeline: ## check format code
	@mvn prettier:check

.PHONY: help start install-deps clean new_day