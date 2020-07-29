package comparable_comparator;

import static org.junit.Assert.assertThat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import com.google.common.collect.Lists;
import static org.hamcrest.Matchers.*;
class Human_LambdaTest {
	@Test
	public void whenSortingEntitiesByName_thenCorrectlySorted() {
	    List<Human_Lambda> humans = Lists.newArrayList(
	      new Human_Lambda("Sarah", 10), 
	      new Human_Lambda("Jack", 12)
	    );
	     
	    humans.sort(
	      (Human_Lambda h1, Human_Lambda h2) -> h1.getName().compareTo(h2.getName()));
	  
	    assertThat(humans.get(0), equalTo(new Human_Lambda("Jack", 12)));
	}
	@Test
	public void
	  givenMethodDefinition_whenSortingEntitiesByNameThenAge_thenCorrectlySorted() {
	     
	    List<Human_Lambda> humans = Lists.newArrayList(
	      new Human_Lambda("Sarah", 10), 
	      new Human_Lambda("Jack", 12)
	    );
	     //using the static method as a Comparator
	    humans.sort(Human_Lambda::compareByNameThenAge);
	    Assert.assertThat(humans.get(0), equalTo(new Human_Lambda("Jack", 12)));
	}
	@Test
	public void
	  givenComposition_whenSortingEntitiesByNameThenAge_thenCorrectlySorted() {
	     
	    List<Human_Lambda> humans = Lists.newArrayList(
	      new Human_Lambda("Sarah", 10,105), 
	      new Human_Lambda("Sarah", 10,101), 
	      new Human_Lambda("Zack", 12,100)
	    );
	 
	    humans.sort(
	      Comparator.comparing(Human_Lambda::getName).thenComparing(Human_Lambda::getAge).thenComparing(Human_Lambda::getHeight)
	    );
	     
	    Assert.assertThat(humans.get(0), equalTo(new Human_Lambda("Sarah", 10,101)));
	}
}
