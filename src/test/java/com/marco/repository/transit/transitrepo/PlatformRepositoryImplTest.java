//package com.marco.repository.transit.transitrepo;
//
//import com.marco.domain.transit.Platform;
//import com.marco.factory.transit.PlatformFactory;
//import org.junit.*;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Optional;
//import java.util.Set;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class PlatformRepositoryImplTest {
//    @Autowired
//    private PlatformRepository repository;
//    private Platform platform;
//
//    private Platform getRepo(){
//        for(Platform platformA : repository.findAll()){
//            if(platformA.getPlatformNumber() == platform.getPlatformNumber()){
//                return platformA;
//            }
//        }
//        return null;
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        platform = PlatformFactory.buildPlatform(10, 12);
//    }
//
//    @Test
//    public void d_getAllPlatforms() {
//        Set<Platform> set = (Set<Platform>) repository.findAll();
//        Assert.assertEquals(1, set.size());
//    }
//
//    @Test
//    public void a_create() {
//        Platform platformTest = this.repository.save(platform);
//        Assert.assertEquals(platform, platformTest);
//    }
//
//    @Test
//    public void c_update() {
//        Assert.assertNotNull(getRepo());
//        int platformLength = 5;
//        Platform updated = new Platform.Builder().copy(getRepo()).platformLength(platformLength).build();
//
//        this.repository.save(updated);
//
//        Assert.assertEquals(platformLength, updated.getPlatformLength());
//        System.out.println("Platform updated");
//    }
//
//    @Test
//    public void e_delete() {
//        repository.deleteById(platform.getPlatformNumber());
//        Set<Platform> platforms = (Set<Platform>) repository.findAll();
//        Assert.assertEquals(0, platforms.size());
//    }
//
//    @Test
//    public void b_read() {
//        Optional<Platform> platformRead = repository.findById(10);
//        Assert.assertTrue(platformRead.isPresent());
//        Assert.assertEquals(platform.getPlatformNumber(), platformRead.get().getPlatformNumber());
//    }
//}