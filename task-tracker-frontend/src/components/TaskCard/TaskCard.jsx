export default function TaskCard(props) {
    const { task } = props;
    const { id, title, description, status } = task;
  
    return (
      <div className="card">
        <div className="card-body">
          <h5 className="card-title">{title}</h5>
          <p className="card-text">{description}</p>
          <p className="card-text">{status}</p>
          <button className="btn btn-primary">Edit</button>
          <button className="btn btn-danger">Delete</button>
        </div>
      </div>
    );
  }