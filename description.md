HOW TO UPDATE THE WIKI

Since it's not possible to include the changes to the wiki into a pull request, here is a way to update the wiki, while still keeping tight control.
1- Create a new repository on your github account, for example, called "Edited-wiki".
2- Clone the wiki repo that you want to update to your local machine somewhere: 'git clone [https://github.com/UNIZAR-30246-WebEngineering/lab1-git-race.wiki.git]'
3- Add a new remote to your local directory, for example: 'git remote add editWiki [https://github.com/nebur395/Edited-wiki]'
4- Make your locally changes and then push them to your github account: 'git push editWiki master'
5-  Submit a issue to the official page (https://github.com/UNIZAR-30246-WebEngineering/lab1-git-race) requesting to the owner of the repo to review your changes and merge them in. Don't forget to include a link to your own repo and describe what you've changed.