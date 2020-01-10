const assert = require("assert");
const database = require("../src/database/database");

describe("MovieDatabase", () => {
  // Testcase
  it("should accept a movie", done => {
    // wat verwachten we dat waar is?
    const movie = {
      title: "finding nemo",
      description: "beschrijving",
      year: 2004,
      actors: []
    };
    database.addMovie(movie, (err, result) => {
      if (err) {
        done(err.message);
      }
      if (result) {
        const id = result.id;
        assert(database.movies[id].title === "finding nemo");
        done();
      }
    });
  });
});
