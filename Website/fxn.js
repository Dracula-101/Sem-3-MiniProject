const navToggle = document.querySelector('.nav-toggle');
const navLinks = document.querySelectorAll('.nav__link')

navToggle.addEventListener('click', () => {
    document.body.classList.toggle('nav-open');
});

navLinks.forEach(link => {
    link.addEventListener('click', () => {
        document.body.classList.remove('nav-open');
    })
})

const typedText = document.querySelector(".typed");
const textArray = ["FQuest","Roulette", "TicTacToe","Pong","Guess-It"];
const typingDelay = 150;
const eraseDelay = 90;
const newTextDelay = 1000;
let textArrayIndex = 0;
let charIndex = 0;

function type(){
	if(charIndex<textArray[textArrayIndex].length){
		typedText.textContent += textArray[textArrayIndex].charAt(charIndex);
		charIndex++;
		setTimeout(type, typingDelay);
	}
    else{
        setTimeout(erase, newTextDelay);
    }
}

function erase(){
    if(charIndex>0){
        typedText.textContent=textArray[textArrayIndex].substring(0, charIndex-1);
        charIndex--;
        setTimeout(erase, eraseDelay);
    }
    else{
        textArrayIndex++;
        if(textArrayIndex>=textArray.length) textArrayIndex=0;
        setTimeout(type, typingDelay+1000);

    }

}
document.addEventListener("DOMContentLoaded", function() {
    setTimeout(type, newTextDelay+200);
});