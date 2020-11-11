@echo off

echo "Updating Project Files..."

REM add current changes to the git index
git add .

REM Stash local changes away
git stash save

REM Pull new code
git pull

echo "Updating Project Files completed."