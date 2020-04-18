package cn;

import cn.entity.*;
import cn.mapper.CheckMapper;
import cn.mapper.ModelMapper;
import cn.service.AdviceService;
import cn.service.DiseaseService;
import cn.service.PrescriptionService;
import com.alibaba.druid.filter.config.ConfigTools;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test1 {
    @Resource
    ModelMapper modelMapper;
    @Resource
    CheckMapper checkMapper;
    @Resource
    PrescriptionService prescriptionService;
    @Resource
    AdviceService adviceService;
    @Resource
    DiseaseService diseaseService;
    @Test
    public void test1(){
        Prescription prescription = new Prescription();
        prescription.setEmployeeId(1);
        prescription.setKindId(1);
        prescription.setPatientId(2);
        prescription.setPname("处方1");
        prescription.setId(prescriptionService.addPrescription(prescription));
        System.out.println("1111111n="+prescription.getId());
    }
    @Test
    public void test3(){
            List<PrescriptionModel> list = modelMapper.findModel(null,null,null,null,null);
        System.out.println(list.toString());
    }
    @Test
    public void test4(){
        PrescriptionAdvice prescriptionAdvice = new PrescriptionAdvice();
        prescriptionAdvice.setAdviceId(1);
        prescriptionAdvice.setPrescriptionId(1);
        int n=adviceService.addAdvice(prescriptionAdvice);
        System.out.println("22222n="+n);
    }
    @Test
    public void test5(){
        PrescriptionDisease prescription = new PrescriptionDisease();
        prescription.setDiseaseId(1);
        prescription.setPrescriptionId(1);
        int n=diseaseService.addDisease(prescription);
        System.out.println("3333n="+n);
    }
    @Test
    public void test2(){
        try {
            String pwd = "root";
            String[] str = ConfigTools.genKeyPair(512);
            System.out.println("privateKey:" + str[0]);
            System.out.println("publicKey:" + str[1]);
            pwd = ConfigTools.encrypt(str[0], pwd);
            System.out.println("加密后的password:" + pwd);
            System.out.println("解密后的password:" + ConfigTools.decrypt(str[1],pwd));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
