import './styles.css';

type Props = {
  text: string;
}

function ButtonNextPage({ text }: Props) {
  return (
    <div className="book-btn-next-page">
      {text}
    </div>
  )
}

export default ButtonNextPage
