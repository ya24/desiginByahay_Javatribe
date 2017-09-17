package cn.ya.javatribe.service.admin;

import cn.ya.javatribe.model.admin.Page;
import cn.ya.javatribe.model.generator.Affiche;
import cn.ya.javatribe.model.generator.Attachfile;

import java.util.List;

/**
 * Created by 叶雅芳 on 2017/3/28.
 */
public interface AfficheManagerService {

    int insertAffiche(Affiche record);

    String insertAttachfile(Attachfile attachfile);

    Page<Affiche> queryAllAfficheByPage(Integer currentPage);

    Affiche queryAfficheById(Integer afficheId);

    Attachfile queryAttachfileById(String attachfileId);

    int updateAffiche(Affiche affiche);

    boolean deleteAttachFile(String attachfileId);

    int delAfficheById(Integer afficheId);
}
