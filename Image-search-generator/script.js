const searchForm = document.getElementById("search-form");
const searchBox = document.getElementById("search-box");
const searchResult = document.getElementById("search-result");
const showMoreButton = document.getElementById("show-more-button");

let keyword = "";
let page = 1;
const accessKey = "p8qNvD3AxfKaF-yKK2JueQb__47oTioHt7ZYNceqbc4";

async function searchImages() {
  keyword = searchBox.value;
  const url = `https://api.unsplash.com/search/photos?page=${page}&query=${keyword}&client_id=${accessKey}&per_page=12`;
  const response = await fetch(url);
  const data = await response.json();

  const result = data.results;

  result.map((result) => {
    const image = document.createElement("img");
    image.src = result.urls.small;
    searchResult.appendChild(image);
  });
  showMoreButton.style.display = "block";
}

searchForm.addEventListener("submit", (e) => {
  e.preventDefault();
  page = 1;
  searchResult.innerHTML = "";
  searchImages();
});

showMoreButton.addEventListener("click", () => {
  page++;
  searchImages();
});
