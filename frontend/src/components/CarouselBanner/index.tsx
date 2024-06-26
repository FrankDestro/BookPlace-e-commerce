import banner2 from '../../assets/img/banner2.png';
import banner3 from '../../assets/img/banner3.png';
import banner4 from '../../assets/img/banner4.png';

function CarouselBanner() {
  return (
    <div>
      <div id="carouselExampleIndicators" className="carousel slide" data-bs-ride="carousel">
        <div className="carousel-indicators">
          <button
            type="button"
            data-bs-target="#carouselExampleIndicators"
            data-bs-slide-to="0"
            className="active"
            aria-current="true"
            aria-label="Slide 1"
          ></button>
          <button
            type="button"
            data-bs-target="#carouselExampleIndicators"
            data-bs-slide-to="1"
            aria-label="Slide 2"
          ></button>
          <button
            type="button"
            data-bs-target="#carouselExampleIndicators"
            data-bs-slide-to="2"
            aria-label="Slide 3"
          ></button>
        </div>
        <div className="carousel-inner">
          {/* Banner 1 */}
          <div className="carousel-item active">
            <img
              src={banner4}
              className="d-block w-100"
              alt="Banner 1"
            />
          </div>
          {/* Banner 2 */}
          <div className="carousel-item">
            <img
             src={banner2}
              className="d-block w-100"
              alt="Banner 2"
            />
          </div>
          {/* Banner 3 */}
          <div className="carousel-item">
            <img
             src={banner3}
              className="d-block w-100"
              alt="Banner 3"
            />
          </div>
        </div>
        <button
          className="carousel-control-prev"
          type="button"
          data-bs-target="#carouselExampleIndicators"
          data-bs-slide="prev"
        >
          <span className="carousel-control-prev-icon" aria-hidden="true"></span>
          <span className="visually-hidden">Previous</span>
        </button>
        <button
          className="carousel-control-next"
          type="button"
          data-bs-target="#carouselExampleIndicators"
          data-bs-slide="next"
        >
          <span className="carousel-control-next-icon" aria-hidden="true"></span>
          <span className="visually-hidden">Next</span>
        </button>
      </div>
    </div>
  );
}

export default CarouselBanner;
