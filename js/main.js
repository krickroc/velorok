var nbVotes = [0, 0];

var buttons = document.querySelectorAll('.travel-list-item .content .vote button');
var spans = document.querySelectorAll('.travel-list-item .content .vote span');

for (let i = 0; i < buttons.length; i++) {
    buttons[i].addEventListener('click', () => {
        nbVotes[i] = nbVotes[i] + 1;
        spans[i].innerHTML = nbVotes[i] + ' votes';
    });
}