package com.onlinecode.core.dao;

import com.onlinecode.core.map.MMap;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DefaultAuthenticationProviderDao {
    MMap getUserByName(MMap param);

    int lockedUser(MMap param);

    int trackSaveUserLock(MMap param);

    int trackUpdateUserLock(MMap param);

    int trackUpdateUserIsLocked(MMap param);

    int updateLoginSuccess(MMap param);
    int deleteUserLockCountBYUserName(MMap param);
    MMap getTrackUserLockByUserName(MMap param);
    MMap getUserAccountLockByUserName(MMap param);
}
