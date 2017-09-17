package cn.ya.javatribe.service.admin.impl;

import cn.ya.javatribe.mapper.admin.AfficheManagerMapper;
import cn.ya.javatribe.mapper.generator.AfficheMapper;
import cn.ya.javatribe.mapper.generator.AttachfileMapper;
import cn.ya.javatribe.model.admin.Page;
import cn.ya.javatribe.model.generator.Affiche;
import cn.ya.javatribe.model.generator.Attachfile;
import cn.ya.javatribe.service.admin.AfficheManagerService;
import cn.ya.javatribe.utils.PageConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * Created by 叶雅芳 on 2017/3/28.
 */
@Service("afficheManagerService")
public class AfficheManagerServiceImpl implements AfficheManagerService{

    @Autowired
    private AfficheMapper afficheMapper;

    @Autowired
    private AttachfileMapper attachfileMapper;

    @Autowired
    private AfficheManagerMapper afficheManagerMapper;

    public int insertAffiche(Affiche record){
        record.setStatus(1);
        return afficheMapper.insertSelective(record);
    }

    // 添加附件
    public  String insertAttachfile(Attachfile attachfile){
        // 生成主键
        String id = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        attachfile.setAttachfileId(id);
        int result = attachfileMapper.insertSelective(attachfile);
        if (result == 1){
            return id;
        }
        return null;
    }

    // 查询分页已发布公告
    public Page<Affiche> queryAllAfficheByPage(Integer currentPage){
        Page<Affiche> affichePage = new Page<Affiche>();
        affichePage.setCurrentPage(currentPage);
        affichePage.setTotalRecord(afficheManagerMapper.countAffiche());
        affichePage.setPageSize(PageConstants.AFFICHE_PAGE_SIZE);
        List<Affiche> afficheList = afficheManagerMapper.queryAllAfficheByPage(affichePage);
        affichePage.setDatas(afficheList);
        return affichePage;
    }

    // 查询公告内容
    public Affiche queryAfficheById(Integer afficheId){
        return afficheMapper.selectByPrimaryKey(afficheId);
    }

    // 查询附件内容
    public Attachfile queryAttachfileById(String attachfileId){
        return attachfileMapper.selectByPrimaryKey(attachfileId);
    }

    // 修改公告
    public int updateAffiche(Affiche affiche){
        affiche.setStatus(1);
        return afficheMapper.updateByPrimaryKeyWithBLOBs(affiche);
    }

    // 删除附件
    @Transactional
    public boolean deleteAttachFile(String attachfileId){

        // 先获取附件的信息
        Attachfile attachfile = attachfileMapper.selectByPrimaryKey(attachfileId);

        String attachfilePath = attachfile.getAttachfilePath();


        //删除数据库中的附件信息
        int  atresult= attachfileMapper.deleteByPrimaryKey(attachfileId);

        //更改公告数据库中的附件ID
        int afresult = afficheManagerMapper.updateAttachfileByAffiche(attachfileId);

        if (atresult ==1 && afresult==1){
            //删除附件文件
            File afile = new File(attachfilePath);
            return afile.delete();
        }

        return false;
    }

    // 删除公告
    public int delAfficheById(Integer afficheId){
        Affiche affiche = new Affiche();
        affiche.setAfficheId(afficheId);
        affiche.setStatus(0);
        return afficheManagerMapper.delAfficheById(affiche);
    }
}
