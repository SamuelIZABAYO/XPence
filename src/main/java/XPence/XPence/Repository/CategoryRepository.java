package XPence.XPence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import XPence.XPence.Model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
