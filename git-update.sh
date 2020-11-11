#!/bin/bash -e

echo "Updating Project Files..."

# add current changes to the git index
git add .

# Stash local changes away
git stash save

# Pull new code
git pull

echo "Updating Project Files completed."