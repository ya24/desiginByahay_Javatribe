package cn.ya.javatribe.mapper.admin;

import cn.ya.javatribe.model.admin.Page;
import cn.ya.javatribe.model.generator.Affiche;

import java.util.List;

/**
 * Created by 叶雅芳 on 2017/3/30.
 */
public interface AfficheManagerMapper {

    // 查询出已发布公告的总记录数
    int countAffiche();

    // 查询分页已发布公告
    List<Affiche>  queryAllAfficheByPage(Page<Affiche> affichePage);

    // 更改公告的附件ID为null
    int updateAttachfileByAffiche(String attachiFileId);

    // 删除公告
    int delAfficheById(Affiche affiche);

}
