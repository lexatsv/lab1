# Четыре задачи Java и практика Git
Номер 28 даёт тему 13 из 15 — простые числа. По заданию дополнительно выбраны
калькулятор, палиндром и конвертер температур; каждая задача разрабатывалась в ветке.
```powershell
New-Item -ItemType Directory out -Force
javac -encoding UTF-8 --release 17 -d out src/*.java tests/*.java
java -Dfile.encoding=UTF-8 -cp out Main
java -Dfile.encoding=UTF-8 -cp out SmokeTest
git log --all --oneline --graph
```
Рабочий проект содержит настоящую историю, четыре feature-ветки, конфликтные слияния,
rebase, cherry-pick, stash и revert. Даты коммитов соответствуют выполненному запуску.
В resources лежит пример разрешённого конфликта ресурса. Журнал команд — ../evidence/git-session.txt.
Локальный bare remote ../remote.git демонстрирует push/fetch/pull/clone без аккаунта.
GitHub Pull Request: https://github.com/lexatsv/lab1/pull/2
Ветка публикации codex/lab2-git-practice сохраняет исходные файлы GitHub и добавляет IPPRPO/lab2.
