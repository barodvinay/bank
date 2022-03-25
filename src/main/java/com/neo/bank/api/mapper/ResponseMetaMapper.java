package com.neo.bank.api.mapper;

import com.neo.bank.api.model.ResponseMeta;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ResponseMetaMapper {

    public ResponseMeta mapResponseMeta(String code, String message) {
      return ResponseMeta.builder()
              .code(code)
              .message(message)
              .build();
    }
}