package es.wata.warenkorb.auth;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class SimpleGrantedAuthorityMixin {

		@JsonCreator
		public SimpleGrantedAuthorityMixin(@JsonProperty("authoritiy") String role) {}
}
