package com.xph.web.Repositories;

import com.xph.web.annotation.TargetDataSource;
import com.xph.web.config.datasource.DbKey;
import com.xph.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by huipei.x on 2016/10/19 0019.
 */

public interface UserRepository extends JpaRepository<User,Long>{
}
