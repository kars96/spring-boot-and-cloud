package com.restwebservices.webservices.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restwebservices.webservices.models.OrgInfo;
import com.restwebservices.webservices.models.OrgInfoV2;

@RestController
public class OrgController {
	// Types of Versioning
	// 1. api segment
	
	@GetMapping("/v1/api/org")
	public ResponseEntity<OrgInfo> getOrgInfoV1_api() {
		return ResponseEntity.ok(new OrgInfo());
	}
	
	@GetMapping("/v2/api/org")
	public ResponseEntity<OrgInfoV2> getOrgInfoV2_api() {
		return ResponseEntity.ok(new OrgInfoV2());
	}
	
	// 2. request params
	
	@GetMapping(path = "/api/org", params = "version=1")
	public ResponseEntity<OrgInfo> getOrgInfoV1_param() {
		return ResponseEntity.ok(new OrgInfo());
	}
	
	@GetMapping(path = "/api/org", params = "version=2")
	public ResponseEntity<OrgInfoV2> getOrgInfoV2_param() {
		return ResponseEntity.ok(new OrgInfoV2());
	}
	
	// Request Header
	
	@GetMapping(path = "/api/org", headers = "X-API-VERSION=1")
	public ResponseEntity<OrgInfo> getOrgInfoV1_header() {
		return ResponseEntity.ok(new OrgInfo());
	}
	
	@GetMapping(path = "/api/org", headers = "X-API-VERSION=2")
	public ResponseEntity<OrgInfoV2> getOrgInfoV2_header() {
		return ResponseEntity.ok(new OrgInfoV2());
	}
	
	// MIME type
	@GetMapping(path = "/api/org", produces = "application/abc.v1+json")
	public ResponseEntity<OrgInfo> getOrgInfoV1_mime() {
		return ResponseEntity.ok(new OrgInfo());
	}
	
	@GetMapping(path = "/api/org", produces = "application/abc.v2+json")
	public ResponseEntity<OrgInfoV2> getOrgInfoV2_mime() {
		return ResponseEntity.ok(new OrgInfoV2());
	}
	
}
