const sliderTrack = document.querySelector(".slider-track");
const sliderItems = document.querySelectorAll(".slider-item");
const prevButton = document.querySelector(".slider-prev");
const nextButton = document.querySelector(".slider-next");
let currentIndex = 0;

function updateSliderPosition() {
  const itemWidth = sliderItems[0].offsetWidth;
  sliderTrack.style.transform = `translateX(-${currentIndex * itemWidth * 5}px)`;
}

function nextSlide() {
  currentIndex = (currentIndex + 1) % Math.ceil(sliderItems.length / 5);
  updateSliderPosition();
}

function prevSlide() {
  currentIndex = (currentIndex - 1 + Math.ceil(sliderItems.length / 5)) % Math.ceil(sliderItems.length / 5);
  updateSliderPosition();
}

nextButton.addEventListener("click", nextSlide);
prevButton.addEventListener("click", prevSlide);

updateSliderPosition();