import "./styles.css";

function SearchBar() {
  return (
    <form className="book-search-bar">
      <button type="submit" style={{ cursor: "pointer" }}>
        🔎︎
      </button>
      <input type="text" placeholder="Nome do produto" />
      <button type="reset" style={{ cursor: "pointer" }}>
        🗙
      </button>
    </form>
  );
}

export default SearchBar;
