
help: ## show make targets
	@awk 'BEGIN {FS = ":.*?## "} /[a-zA-Z_-]+:.*?## / {sub("\\\\n",sprintf("\n%22c"," "), $$2);printf " \033[36m%-20s\033[0m  %s\n", $$1, $$2}' $(MAKEFILE_LIST)

start: install_deps ## add gitHooks and install dependencies
	@git config core.hooksPath .githooks

install_deps: ## install deps
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

check_format: ## check format code
	@./mvnw prettier:check

all_tests_pipeline: ## execute all tests for pipeline
	@mvn test

check_format_pipeline: ## check format code for pipeline
	@mvn prettier:check

.PHONY: help start install_deps clean new_day remove_day all_tests test format check_format all_tests_pipeline check_format_pipeline