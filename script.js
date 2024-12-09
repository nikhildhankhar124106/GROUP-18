let timerInterval;
let elapsedTime = 0;

const timeDisplay = document.getElementById('time-display');
const startBtn = document.getElementById('start-btn');
const stopBtn = document.getElementById('stop-btn');
const resetBtn = document.getElementById('reset-btn');

window.onload = () => {
  const savedTime = localStorage.getItem('stopwatch-time');
  if (savedTime) {
    elapsedTime = parseInt(savedTime, 10);
    updateTimeDisplay();
    resetBtn.disabled = false;
  }
};

startBtn.addEventListener('click', () => {
  startBtn.disabled = true;
  stopBtn.disabled = false;
  resetBtn.disabled = false;

  timerInterval = setInterval(() => {
    elapsedTime++;
    updateTimeDisplay();
  }, 1000);
});

stopBtn.addEventListener('click', () => {
  clearInterval(timerInterval);
  startBtn.disabled = false;
  stopBtn.disabled = true;
  localStorage.setItem('stopwatch-time', elapsedTime);
});

resetBtn.addEventListener('click', () => {
  clearInterval(timerInterval);
  elapsedTime = 0;
  updateTimeDisplay();
  startBtn.disabled = false;
  stopBtn.disabled = true;
  resetBtn.disabled = true;
  localStorage.removeItem('stopwatch-time');
});

function updateTimeDisplay() {
  const hours = String(Math.floor(elapsedTime / 3600)).padStart(2, '0');
  const minutes = String(Math.floor((elapsedTime % 3600) / 60)).padStart(2, '0');
  const seconds = String(elapsedTime % 60).padStart(2, '0');
  timeDisplay.textContent = `${hours}:${minutes}:${seconds}`;
}