import React, { useState } from "react";
import axios from "axios";

const AddProduct = () => {
  const [product, setProduct] = useState({
    name: "",
    brand: "",
    description: "",
    price: "",
    category: "",
    stockQuantity: "",
    releaseDate: "",
    productAvailable: false,
  });

  const [image, setImage] = useState(null);

  // Handle text / number / date inputs
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setProduct((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  // Handle image input
  const handleImageChange = (e) => {
    setImage(e.target.files[0]);
  };

  const submitHandler = async (e) => {
    e.preventDefault();

    // 🔥 FIX: Convert strings → correct types BEFORE sending
    const fixedProduct = {
      name: product.name.trim(),
      brand: product.brand.trim(),
      description: product.description.trim(),
      category: product.category,
      price: product.price === "" ? 0 : Number(product.price),
      stockQuantity:
        product.stockQuantity === "" ? 0 : Number(product.stockQuantity),
      releaseDate: product.releaseDate, // yyyy-MM-dd
      productAvailable: Boolean(product.productAvailable),
    };

    const formData = new FormData();
    formData.append("imageFile", image);
    formData.append(
      "product",
      new Blob([JSON.stringify(fixedProduct)], {
        type: "application/json",
      })
    );

    try {
      const response = await axios.post(
        "http://localhost:8080/api/product",
        formData,
        {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        }
      );

      alert("Product added successfully");
      console.log(response.data);
    } catch (error) {
      console.error("Error adding product:", error);
      alert("Error adding product");
    }
  };

  return (
    <div className="container">
      <div className="center-container">
        <form className="row g-3 pt-5" onSubmit={submitHandler}>
          <div className="col-md-6">
            <label className="form-label">Name</label>
            <input
              type="text"
              className="form-control"
              name="name"
              value={product.name}
              onChange={handleInputChange}
              required
            />
          </div>

          <div className="col-md-6">
            <label className="form-label">Brand</label>
            <input
              type="text"
              className="form-control"
              name="brand"
              value={product.brand}
              onChange={handleInputChange}
              required
            />
          </div>

          <div className="col-12">
            <label className="form-label">Description</label>
            <input
              type="text"
              className="form-control"
              name="description"
              value={product.description}
              onChange={handleInputChange}
            />
          </div>

          <div className="col-md-4">
            <label className="form-label">Price</label>
            <input
              type="number"
              className="form-control"
              name="price"
              value={product.price}
              onChange={handleInputChange}
              required
            />
          </div>

          <div className="col-md-4">
            <label className="form-label">Category</label>
            <select
              className="form-select"
              name="category"
              value={product.category}
              onChange={handleInputChange}
              required
            >
              <option value="">Select category</option>
              <option value="Laptop">Laptop</option>
              <option value="Mobile">Mobile</option>
              <option value="Electronics">Electronics</option>
              <option value="Fashion">Fashion</option>
            </select>
          </div>

          <div className="col-md-4">
            <label className="form-label">Stock Quantity</label>
            <input
              type="number"
              className="form-control"
              name="stockQuantity"
              value={product.stockQuantity}
              onChange={handleInputChange}
              required
            />
          </div>

          <div className="col-md-4">
            <label className="form-label">Release Date</label>
            <input
              type="date"
              className="form-control"
              name="releaseDate"
              value={product.releaseDate}
              onChange={handleInputChange}
            />
          </div>

          <div className="col-md-4">
            <label className="form-label">Image</label>
            <input
              type="file"
              className="form-control"
              onChange={handleImageChange}
            />
          </div>

          <div className="col-12">
            <div className="form-check">
              <input
                className="form-check-input"
                type="checkbox"
                checked={product.productAvailable}
                onChange={(e) =>
                  setProduct((prev) => ({
                    ...prev,
                    productAvailable: e.target.checked,
                  }))
                }
              />
              <label className="form-check-label">
                Product Available
              </label>
            </div>
          </div>

          <div className="col-12">
            <button type="submit" className="btn btn-primary">
              Submit
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default AddProduct;
