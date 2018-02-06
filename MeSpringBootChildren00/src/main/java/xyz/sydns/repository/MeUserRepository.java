package xyz.sydns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import xyz.sydns.entity.MeUser;

/**
 * @author sqsgalaxys
 */
@RepositoryRestResource
public interface MeUserRepository extends JpaRepository<MeUser, String> {
// public interface MeUserRepository extends CrudRepository<MeUser, Long> {

    // public findByAgeLessThanEqual

    /// @Transactional(timeout = 10)
    @Query("select u from MeUser u where u.meName = ?1")
    MeUser findByMeName(String meName);

}
