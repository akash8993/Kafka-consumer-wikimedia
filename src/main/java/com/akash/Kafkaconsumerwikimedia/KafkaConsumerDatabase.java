package com.akash.Kafkaconsumerwikimedia;

import com.akash.Kafkaconsumerwikimedia.entity.WikimediaData;
import com.akash.Kafkaconsumerwikimedia.repository.WikimediaDataRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerDatabase {

    private static final Logger logger= LoggerFactory.getLogger(KafkaConsumerDatabase.class);

    @Autowired
    private WikimediaDataRepo wikimediaDataRepo;
    @KafkaListener(topics = "wikimedia_recentchange", groupId = "myGroup")
    public void consume(String eventMessage)
    {
        logger.info(String.format("Data recieved -> %s", eventMessage));
        WikimediaData wikimediaData= new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);
        wikimediaDataRepo.save(wikimediaData);
    }
}
