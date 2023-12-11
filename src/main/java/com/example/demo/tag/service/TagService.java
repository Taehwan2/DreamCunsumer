package com.example.demo.tag.service;

import com.example.demo.tag.db.Tag;
import com.example.demo.tag.db.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public Tag enrollTag(Tag tag){
        return tagRepository.save(tag);
    }
}
